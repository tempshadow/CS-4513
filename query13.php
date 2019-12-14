<?php
    $serverName = "mans8927-sql-server.database.windows.net"; //server info
    $connectionInfo = array( "Database"=>"Job-Shop-Accounting-Database-System", "UID"=>"mans8927", "PWD"=>"ClaEli2718" );//database information
    $conn = sqlsrv_connect( $serverName, $connectionInfo);//connection string
    $first = $_POST['input1'];//input from user
    $second = $_POST['input2'];//input from user
     $tsql= "SELECT CustomerName FROM Customer WHERE Category <= '$second' AND Category >= '$first';";//sql statement
    $getResults= sqlsrv_query($conn, $tsql);//connects and performs query
    if ($getResults == FALSE)
        echo (sqlsrv_errors());//prints
    while ($row = sqlsrv_fetch_array($getResults, SQLSRV_FETCH_ASSOC)) {
     echo ($row['CustomerName'].PHP_EOL);//prints
    }
    sqlsrv_free_stmt($getResults);
?>