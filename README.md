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
    <li></li>
</ul>