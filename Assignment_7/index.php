<!DOCTYPE html>
<html>
<head>
    <title>Student CRUD</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Student Database</h2>

    <?php
    $conn = mysqli_connect("localhost", "root", "root", "student");
    if (!$conn) {
        die("Connection Failed");
    }
    $result = mysqli_query($conn, "SELECT * FROM studentdata");
    ?>

    <h4>Add Student</h4>
    <form action="add.php" method="post" class="mb-3">
        <input type="number" name="roll" placeholder="Roll No" required class="form-control mb-2">
        <input type="text" name="name" placeholder="Name" required class="form-control mb-2">
        <input type="text" name="class" placeholder="Class" required class="form-control mb-2">
        <input type="text" name="address" placeholder="Address" required class="form-control mb-2">
        <button class="btn btn-success">Add</button>
    </form>

    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <th>Roll</th>
            <th>Name</th>
            <th>Class</th>
            <th>Address</th>
            <th>Delete</th>
        </tr>

        <?php while ($row = mysqli_fetch_assoc($result)) { ?>
        <tr>
            <td><?php echo $row['id']; ?></td>
            <td><?php echo $row['rollno']; ?></td>
            <td><?php echo $row['name']; ?></td>
            <td><?php echo $row['class']; ?></td>
            <td><?php echo $row['address']; ?></td>
            <td>
                <a href="delete.php?id=<?php echo $row['id']; ?>" class="btn btn-danger btn-sm">
                    Delete
                </a>
            </td>
        </tr>
        <?php } ?>
    </table>
</div>

</body>
</html>