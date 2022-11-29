//create database
use employees;

//create collection
db.createCollection("employee",{
    validator:{
      $jsonSchema:{
        bsonType: "object",
        required: ["name", "address","department", "salary" ],
        properties:{
          name:{
            bsonType:"string",
             description:"name of the employee"
            },
          address:{
            bsonType:"string",
            description:"address of employee"
          },
          department:{
            bsonType:"string",
            description:"department of employee"
          },
          salary:{
            bsonType:"int",
            description: "salary information"
          }
        }
      }
    }
  });


//show collection
show collections;


//insert
db.employee.insertMany([
    {name:'abc',address:'Bangalore',department:'sales',salary:30000},
    {name:'cde',address:'Bangalore',department:'engineering',salary:80000},
    {name:'efg',address:'Bangalore',department:'marketing',salary:50000},
    {name:'hij',address:'Bangalore',department:'testing',salary:40000},
    {name:'klm',address:'Bangalore',department:'sales',salary:30000},
]);


db.employee.find().pretty();

//update a record
db.employee.updateOne({name:'klm'},{$set:{department:'Quality Assurance'}});


db.employee.find().pretty();

//delete a record
db.employee.remove({name:'hij'});

db.employee.find().pretty();

