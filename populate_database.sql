CREATE TABLE Customer (
    CustomerName VARCHAR(20) PRIMARY KEY NOT NULL, 
    CustomerAddress VARCHAR(85) NOT NULL, 
    Category INT NOT NULL
);

CREATE TABLE Department(
    DepartmentNumber INT PRIMARY KEY NOT NULL,
    DepartmentData VARCHAR(85) NOT NULL
);

CREATE TABLE Assembly(
    AssemblyID int PRIMARY KEY NOT NULL,
    DateOrdered DATE NOT NULL,
    AssemblyDetails VARCHAR(85) NOT NULL,
    CustomerName VARCHAR(20) FOREIGN KEY REFERENCES Customer(CustomerName)
);
CREATE TABLE Process (
    ProcessID int NOT NULL PRIMARY KEY,
    DepartmentNumber INT FOREIGN KEY REFERENCES Department(DepartmentNumber)
);
CREATE TABLE Fit(
    FitType VARCHAR(85) NOT NULL,
    ProcessID int FOREIGN KEY REFERENCES Process(ProcessID)
);
CREATE TABLE Paint(
    PaintType VARCHAR(85) NOT NULL,
    PaintingMethod VARCHAR(85) NOT NULL,   
    ProcessID int FOREIGN KEY(ProcessID) REFERENCES Process(ProcessID)
);
CREATE TABLE Cut(
    CuttingType VARCHAR(85) NOT NULL,
    MachineType VARCHAR(85) NOT NULL,
    ProcessID int FOREIGN KEY(ProcessID) REFERENCES Process(ProcessID)
);

CREATE TABLE Account(
    AccountNumber INT PRIMARY KEY NOT NULL,
    EstablishDate DATE NOT NULL
);
CREATE TABLE AssemblyAccount(
    Costs DECIMAL(19, 4) NOT NULL,
    AccountNumber INT FOREIGN KEY(AccountNumber) REFERENCES Account(AccountNumber),
    AssemblyID INT FOREIGN KEY(AssemblyID) REFERENCES Assembly(AssemblyID)
);
CREATE TABLE DepartmentAccount(
    Costs DECIMAL(19, 4) NOT NULL,
    AccountNumber INT FOREIGN KEY(AccountNumber) REFERENCES Account(AccountNumber),
    DepartmentNumber INT FOREIGN KEY(DepartmentNumber) REFERENCES Department(DepartmentNumber)
);
CREATE TABLE ProcessAccount(
    Costs DECIMAL(19, 4) NOT NULL,
    AccountNumber INT FOREIGN KEY(AccountNumber) REFERENCES Account(AccountNumber),
    ProcessID INT FOREIGN KEY(ProcessID) REFERENCES Process(ProcessID)
);
CREATE TABLE Job(
    JobNumber INT PRIMARY KEY NOT NULL,
    AssemblyID INT FOREIGN KEY REFERENCES Assembly(AssemblyID),
    ProcessID INT FOREIGN KEY REFERENCES Process(ProcessID),
    StartDate DATE NOT NULL,
    CompletionDate DATE
);
CREATE TABLE CutJob(
    Machine VARCHAR(85) NOT NULL,
    MachineTime TIME NOT NULL,
    Material VARCHAR(85) NOT NULL,
    Labor FLOAT NOT NULL,
    JobNumber INT FOREIGN KEY REFERENCES Job(JobNumber)
);
CREATE TABLE PaintJob(
    Color VARCHAR(85) NOT NULL,
    Volume VARCHAR(85) NOT NULL,
    Labor FLOAT NOT NULL,
    JobNumber INT FOREIGN KEY REFERENCES Job(JobNumber)
);
CREATE TABLE FitJob(
    Labor FLOAT NOT NULL,
    JobNumber INT FOREIGN KEY REFERENCES Job(JobNumber)
);
CREATE TABLE Transactions(
    TransactionNumber INT PRIMARY KEY NOT NULL,
    SupCost DECIMAL(19, 4) NOT NULL,
    AccountNumber INT FOREIGN KEY REFERENCES Account(AccountNumber)  
);
CREATE INDEX costIndex ON AssemblyAccount(Costs);
CREATE INDEX fitLabor ON FitJob(Labor);
CREATE INDEX cutLabor ON CutJob(Labor);
CREATE INDEX paintLabor ON PaintJob(Labor);
CREATE INDEX paintColor ON PaintJob(Color);