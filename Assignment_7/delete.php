<?php
$conn = mysqli_connect("localhost", "root", "root", "student");

$id = $_GET['id'];

mysqli_query($conn, "DELETE FROM studentdata WHERE id = $id");

header("Location: index.php");
?>