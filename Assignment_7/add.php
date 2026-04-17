<?php
$conn = mysqli_connect("localhost", "root", "root", "student");

$roll = $_POST['roll'];
$name = $_POST['name'];
$class = $_POST['class'];
$address = $_POST['address'];

mysqli_query(
    $conn,
    "INSERT INTO studentdata (rollno, name, class, address)
     VALUES ('$roll', '$name', '$class', '$address')"
);

header("Location: index.php");
?>