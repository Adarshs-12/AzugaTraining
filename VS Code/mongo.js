
//insert
db.planets.insertOne({
    name: 'Dummy',
    orderFromSun: 7,
    hasRings: true,
    mainAtmosphere: [ 'a2z' ],
    surfaceTemperatureC: { min: null, max: null, mean: -1000 }
  })

//insert Many
db.planets.insertMany([
  {
  name: 'azuga',
  orderFromSun: 7,
  hasRings: true,
  mainAtmosphere: [ 'N' , 'Ar' ],
  surfaceTemperatureC: { min: null, max: null, mean: -1000 }},
  {
    name: 'Telematics',
    orderFromSun: 6,
    hasRings: true,
    mainAtmosphere: [ 'CO2' , 'CH4' ],
    surfaceTemperatureC: { min: null, max: null, mean: 1000 }}
])

//find with pretty
db.planets.find().pretty()

db.planets.find().count()

db.planets.find().limit()


//find with filter
  db.planets.find({name:{$eq:'Azuga'}})

  db.planets.find({name:'venus'},{mainAtmosphere:1})

  db.planets.find({orderFromSun:{$in:[3 , 6]}}) //both included

  db.planets.find({orderFromSun:{$nin:[3 , 6]}})  //both notIncluded

  db.planets.find({$and:[{hasRings:true},{orderFromSun:7}]})

  db.planets.find({$or:[{hasRings:false},{orderFromSun:3}]})

  db.planets.find().sort({orderFromSun:1})

  db.planets.find().sort({orderFromSun:-1})



//update
db.planets.updateOne(
    {_id:ObjectId("635a54bd16879bee27af36ef")},
    {$set:{name:'Telematics',orderFromSun:10}}
)

//projections
db.planets.find({name:'Telematics'},
    {name:1,mainAtmosphere:1}
)

//Delete
db.planets.remove({_id: ObjectId("635ba23cc8cb543a61afdc7b")})


//greaterThanEqualTo
db.planets.find({orderFromSun:{$gte:7}})

db.planets.find({orderFromSun:{$lte:4}})

//regex
db.planets.find({mainAtmosphere:{$regex:'He'}})


//Aggregation
db.planets.aggregate(
  {$group:{_id : "$orderFromSun", count :{$sum : 1}}}
)

db.planets.aggregate({ $group: { _id: "$orderFromSun", count: { $sum: 1 } } }, 
                     { $sort: { count: 1 } })


//Working with Arrays

db.planets.find({'Astronaut.name':'john'})

//all operator
db.planets.find({mainAtmosphere:{$all:['CO2','Ar']}})

//size
db.planets.find({mainAtmosphere:{$size:2}})

//Add or push
db.planets.updateOne({name:'Telematics'},{$push:{'Astronaut':{name:'jack',age:35}}})

//Remove or pull
db.planets.updateOne({name:'Mercury'},{$pull:{'Astronaut':{name:'jack',age:35}}})

//Projections
db.planets.find({orderFromSun:4},{'name':1,Astronaut:1})

//Indexes
db.planets.createIndex({'orderFromSun':1})
db.planets.find({'orderFromSun':1}).explain()
db.planets.dropIndex({orderFromSun:1})
db.planets.getIndexes()

//Schema & validation
db.getCollectionInfos()


db.createCollection("science",{
  validator:{
    $jsonSchema:{
      bsonType: 'object',
      required: [
        'name',
        'hasRings',
        'Astronaut'
      ],
      properties:{
        name:{
          bsonType:'string',
           description:'name of the planet'
        },
        orderFromSun:{
          bsonType:'int',
          description:'number of sun in the planet'
        },
        Astronaut:{
          bsonType:'array',
          description: 'Astronaut information'
        }
      }
    }
  }
})


db.runCommand( { collMod: "science",
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: [ "name", "hasRings","Astronaut" ],
         properties: {
            name: {
               bsonType: "string",
               description: "must be a string and is required"
            },
            hasRings: {
               bsonType: "Integer",
               minimun:0 ,
               maximum:10,
               description: "number of rings"
            }
         }
      }
   }
} )



db.science.insertOne({'name':'star','hasRings':true,'Astronaut':[{'name':'xyz','age':50}]})
db.science.insertOne({'name':'star','orderFromSun':4,'hasRings':true,'Astronaut':[{'name':'xyz','age':50}]})
db.science.insertOne({
  name: 'Dummy',
  orderFromSun: 7,
  hasRings: true,
  mainAtmosphere: [ 'a2z' ],
  surfaceTemperatureC: { min: null, max: null, mean: -1000 },
  Astronaut:['abc', 45 ]
})


//map Reduce
db.planets.mapReduce(function(){emit(this.orderFromSun , this.surfaceTemperatureC.mean)},
                    function(key,value){return Arrays.avg(value)},{out:{inline:1}})

db.museum.mapReduce(function(){emit(this.objectID,this.objectBeginDate);},
                   function(key,values){return Array.sum(values)},{out:{inline:1}})
  


//MongoDB tools

//Mongodump
mongodump   //export all database into folder

//export single database
mongodump -d databaseName

//export single collection
mongodump -d databaseName -c collectionName

//Mongorestore - restore the database
mongorestore -d databaseName /path

//restore collection
mongorestore -d databaseName -c collectionName /path

//mongoimport
mongoimport --db museumDB --collection museum --file /Users/azuga/Desktop/museum.json --jsonArray

//mongoexport
mongoexport --db museumDB --collection museum --out file.json

mongoexport --db museumDB --collection museum --csv --out file.csv --fields objectID,isHighlight,accessionNumber,accessionYear,isPublicDomain,primaryImage,primaryImageSmall

mongostat

mongotop

//GridFS
//to store files into database

mongofiles -d video put video.mp4

db.fs.find().pretty()
db.fs.chunks.find({},{data:0,_id:0}).pretty()

//retrive the file
mongofiles -d video get video.mp4

//delete
mongofiles delete video.mp4 --db=video