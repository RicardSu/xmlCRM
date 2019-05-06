# xmlCRM
This is a system about XML
***
## The purpose of this pro: 
### (1) Comprehensively apply the knowledge learned to design a customer relationship management system.
### (2) Requirements:
    1. Do a good job in all preparations before the experiment, familiar with the experimental content and machine operation process.
    2. Comply with laboratory rules and regulations and experimental classroom teaching discipline.
    3. Complete the experimental tasks carefully and fill in the experimental report.
    4. Familiar with related XML development and DOM parsing methods for XML and Eclipse development framework.
***
### (3) the experimental equipment:
    A PC with XML development tools and Eclipse or related software installed.
***
### (4) the experimental content or steps:
    1. Content: According to the knowledge learned above, design an XML-based customer relationship management system, which requires complete requirements analysis, system design, system implementation, and system test description.
    2. Steps:
       System analysis:
       1. The most important are the three main factors in customer relationship management, the addition, viewing and modification of customers, products and sales records.
       2. Customer Management: You can view customer data, add customers, and modify customer data.
       3. Product Management: You can view product information, add products, and modify product information.
       4. Sales record management: You can view sales records and increase sales records.
***
### (5) Data design and implementation:
        Database operation class：
           Customer data management module
           Product Data Management Module
           Sales Management Module
#### Database implementation:
 Create an Access database or use another database SQLserver, etc., and name it CRM
 Add the customierm table, productitem table, and trade table.
#### Database implementation of the customierm table.
    First need to add a schema record in the database
    Then create the customeritem table, you need to specify the Schema mode to use when building the table.
    The trigger needs to be used because the consistency of the attribute customerID in the cid and cinfo fields needs to be guaranteed.
    Since the cinfo field is an XML data type, an XML data segment can be directly inserted into the database table customer. The operation of inserting a record uses the stored procedure addcustomer. By defining a variable str, it saves the XML data to be inserted. Paragraph
***
#### Database implementation of the productitem table.
 First need to add a schema record in the database
 Create trigger setProductItemID
##### System implementation:
 The system is divided into three modules:
 Customer data management module,
 Product data management module,
 Sales Management Module
