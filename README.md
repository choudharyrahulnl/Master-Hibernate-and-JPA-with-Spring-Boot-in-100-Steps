# Master-Hibernate-and-JPA-with-Spring-Boot-in-100-Steps

Github: https://github.com/in28minutes/jpa-with-hibernate

<h3>Relation Mapping: <h3>
<ul>
    <li>Course can have Many Students</li>
    <li>Student can enroll in Many Course</li>
    <li>Course can have many Reviews</li>
    <li>Student can have One Passport</li>
</ul>

<h3>One To One Mapping: </h3>
<ul>
    <li>We can create foreign key on any side either on student or passport</li>
    <li>But it will be convenient if we put on student table so that when we fetch student detail we can get passport details as well</li>
    <li>In hibernate we will use @OneToMany in Student Class on Passport Reference</li>
    <li>This annotation will create passport_id in Student Table if we use hibernate to generate schema</li>
    <li>Now we want to read Student detail from Passport that is from other side of relationship</li>
    <li>If we put @OneToMany in Passport Class on Student Reference</li>
    <li>Then this annotation will create student_id in Passport Table, if we use hibernate for schema generation</li>
    <li>This means Student Table will have student_id & passport_id</li>
    <li>This means Passport Table will have passport_id & student_id</li>
    <li>This leads to data duplication</li>
    <li>To resolve this we can use mappedby</li>
    <li>Mappedby will tell hibernate not to create student_id in Passport Table</li>
    <li>Instead refer to Table Student, and look for column passport_id</li>
    <li>Now fetch the details using passport_id from Student Table</li>
    <li>When we need to save Student & Passport we need to save Passport first, then Student</li>
    <li>Otherwise we will get error that save Passport first</li>
    <li>Alternative we can use Cascade on Student</li>
    <li>Which means you can when we save Student also save Passport</li>
    <li>And hibernate will figure out that Passport needs to save first and then Student</li>
</ul>

<h3>One To Many Mapping: </h3>
<ul>
    <li>We should always crate foreign key many side ex Course can have Many Reviews</li>
    <li>So on the Review Class we will have @ManyToOne which will create course_id column which is a foreign key</li>
    <li>Now on Course Class we can have @OneToMany(mappedBy = "course")</li>
    <li>That means we can now refer to Review Table and course_id column</li>
    <li>We need to add reviews for a course : UI user will click on a Course & add Reviews</li>
    <li>We will fetch Course first</li>
    <li>Set the relationship, set reviews to course & set course to review</li>
    <li>Finally save the reviews as it's the owning side</li>
    <li>Fetching Course which has @OneToMany</li>
	<li> It will fetch in Lazy fashion as @OneToMany is Lazy by default</li>
	<li> Only when we call getReviews on Course then only it will fetch reviews</li>
	<li> Fetching Reviews which has @ManyToOne</li>
	<li> It will fetch in Eager fashion as @ManyToOne is Eager by default</li>
	<li> That means it will fetch Course with Reviews</li>
</ul>


<h3>Many To Many Mapping: </h3>
<ul>
    <li>Course & Students are having Many To Many Relationship</li>
    <li>Course can have multiple Students so having student_id in Course Table won't work</li>
    <li>Student can enroll in multiple Courses so having course_id in Student Table won't work</li>
    <li>So we need to create Join Table Course_Student having course_id & student_id</li>
    <li>So the foreign key is in CourseStudent Table</li>
    <li>If we @ManyToMany on both side then it will create tables student_courses & course_students</li>
    <li>As Course has Students relation and Student has Courses Relation</li>
    <li>We don't want this, to fix this we need to make one side as owning side</li>
    <li>As we are using Join Table, so it does not matter which side is the owning side</li>
    <li>Lets make the Student as the owning side</li>
    <li>For this we need to put mappedby on Courses Class - students list</li>
    <li>Now we will see only one table is created student_courses with students_id & courses_id</li>
    <li>To rename table and its column we can use @JoinTable on owning side ie Student Class</li>
</ul>


<h3>Transaction: </h3>
<ul>
    <li>A: Atomicity - Either all of them should be successful or none of them</li>
    <li>C: Consistency -  Maintain consistent state weather transaction is successful or failed. Ex Transfer some amount form A to B account if successful then amount should be deducted if failed then not</li>
    <li>I: Isolation - Transaction should be in isolation if A transfer some money using ATM and Bank then both transaction should be in isolation </li>
    <li>D: Durability - Once transaction is committed data should be persisted weather System crashes or not</li>
</ul>

<h3>Dirty Read: </h3>
<ul>
    <li>If 2 Transaction are happening in parallel and one transaction read value from other transaction</li>
    <li>Before other transaction is successful or failed</li>
    <li>This lead to in-consistency of data</li>
    <li>Scenario if transaction one failed and other transaction is successful, in this case transaction one will roll back but other transaction has already read the dirty data from transaction one change</li>
</ul>

<h3>Non Repeatable Read: </h3>
<ul>
    <li>If 2 Transaction are happening in parallel</li>
    <li>First transaction read some value</li>
    <li>Second Transaction updated some value</li>
    <li>Again first transaction read same value but will get different data</li>
    <li>Within same transaction we get different data</li>
</ul>


<h3>Phantom Read: </h3>
<ul>
    <li>Same as Non-Repeatable read but in this case we will insert data using other transaction</li>
    <li>So we will get different no of rows in same transaction</li>
</ul>


<h3>Isolation Levels: </h3>
<ul>
    <li>Read Uncommitted: Solves nothing </li>
    <li>Read Committed: Solves Dirty Read </li>
    <li>Repeatable Read: Solves Dirty Read & Non-Repeatable Read (Row is Locked)</li>
    <li>Serializable: Solves Dirty Read & Non-Repeatable Read & Phantom Read (Table Lock for the where constraint), if we read a table using select * from table then all other transaction will wait</li>
</ul>

Note: 
Read Committed is used by most of the application
MySQL has default isolation level of REPEATABLE READ
