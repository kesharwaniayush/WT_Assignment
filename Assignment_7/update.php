<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Update Student</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>

<body>

<?php
$conn = mysqli_connect("localhost", "root", "root", "student");

if (!$conn) {
  die("Connection failed");
}

// Get form data
$id      = $_POST['id'];
$name    = $_POST['name'];
$roll    = $_POST['roll'];
$class   = $_POST['class'];
$address = $_POST['address'];

// Update query
$sql = "UPDATE studentdata 
        SET name='$name', rollno='$roll', class='$class', address='$address' 
        WHERE id='$id'";

// Execute query
if (mysqli_query($conn, $sql)) {
  echo "<div class='alert alert-success text-center'>
          Update Successful!
          <br><a href='index.php' class='btn btn-success mt-2'>Back</a>
        </div>";
} else {
  echo "<div class='alert alert-danger text-center'>
          Update Failed!
        </div>";
}

mysqli_close($conn);
?>

</body>
</html>