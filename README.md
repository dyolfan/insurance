# Insurance

REST API with one endpoint that calculates premium for a policy.

## Requirements:
- Java 11
- Maven 

## How to launch:

Execute those line in bash terminal:
```bash
mvn package
java -jar target/insurance-0.0.1-SNAPSHOT.jar
```

or start application using IntelliJ with main class `com.kputimcevs.insurance.InsuranceApplication.java`.

## Run the tests:

Execute those line in bash terminal:
```bash
mvn clean install
```

## Sample request to API:

```
curl --location --request GET 'http://localhost:8080/premium/policy' \
--header 'Content-Type: application/json' \
--data-raw '{
 "policyNumber": "LV123-12313-12313",
 "policyStatus": "REGISTERED",
 "policyObjects": [
     {
         "objectName": "House",
         "subObjects": [
            { 
                "subObjectName": "TV",
                "sumInsured": 150,
                "riskType": "FIRE"
            },
            {
                "subObjectName": "PC",
                "sumInsured": 200,
                "riskType": "FIRE"
            },
            {
                "subObjectName": "Coffee machine",
                "sumInsured": 50,
                "riskType": "FIRE"
            },
            {
                "subObjectName": "Coffee machine",
                "sumInsured": 20,
                "riskType": "THEFT"
            }
         ]
     },
    {
        "objectName": "Garage",
        "subObjects": [
            {
                "subObjectName": "Toy car",
                "sumInsured": 80,
                "riskType": "THEFT"
            },
            {
                "subObjectName": "Toy car",
                "sumInsured": 100,
                "riskType": "FIRE"
            },
           {
                "subObjectName": "Toolbox",
                "sumInsured": 2.51,
                "riskType": "THEFT"
            }
        ]
    }
 ]
}'
```

## Sample response body:
``` 
{
    "premium": "17.13 EUR"
}
```