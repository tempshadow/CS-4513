<?php
    $serverName = "mans8927-sql-server.database.windows.net";
    $connectionInfo = array( "Database"=>"Job-Shop-Accounting-Database-System", "UID"=>"mans8927", "PWD"=>"ClaEli2718" );
    $conn = sqlsrv_connect( $serverName, $connectionInfo);
    $name = $_POST['cname'];
    $address = $_POST['address'];
    $category = $_POST['ccatagory'];
    $sql= "INSERT INTO Customer (CustomerName, CustomerAddress, Category)"."VALUES ( '$name', '$address', '$category');";
    $params = array(1, "some data");
    $stmt = sqlsrv_query( $conn, $sql, $params);
    echo ("Success in inserting");
    if( $stmt === false ) {
         die( print_r( sqlsrv_errors(), true));
    }
?>