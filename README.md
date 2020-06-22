# Etendering-using-Blockchain

Problem Statement: At present, we mostly use the E-tendering System where the purpose of the system is to provide an online platform for a company to open tenders by conveying all the requirements to quote for that tender and other companies whoever interested can quote. The drawback of the current system is the lack of providing security to sensitive values like the quotation amount quoted by the company. If these sensitive values are exposed then there is a chance that illegitimate companies can secure the Tender. 

Our Solution: One of the solutions to tackle this problem is to implement the E-tendering System using Blockchain Technology. Through the characteristic feature of transparency in blockchain it effectively records every data about ‘which company quoted how much price during the particular time’. One can record every change in the tender details with the help of creating a newly encrypted block using a strong encryption key, thereby making it impossible to view the sensitive information. The encrypted block contains details like quotation price, timestamp and even the hash code. Whenever an intruder tries to alter the encrypted data, the blockchain technology notifies with the help of hash code present in the block. This series of blocks will record every transaction that is made and making the system hack-proof.

Important point : We created our own architecture of blockchain by making use of the blockchain concepts like redundancy storage, encryption, timestamping, chain creation of blocks

Algorithms used : AES for encryption, SHA for hash code of the file contents.

System Features: 
1. A simple webpage used for Login and registration of companies interested in quoting process. 

![image](https://user-images.githubusercontent.com/25890584/85337477-89f40000-b4ae-11ea-9a40-e3a9d9ec6a6f.png)

2. A simple database to validate the login credentials of the companies, and to store metadata of the companies

![image](https://user-images.githubusercontent.com/25890584/85337849-3b933100-b4af-11ea-8eae-d9585fdb8cee.png)


3. A file system level storage: For more security of data, we have stored the tenderer’s quotation information in a filesystem and encrypted it. Each time a tenderer tries to quote for the tender (or) to edit the quotation for the existing tender, a new file is created. Using blockchain technology, the file that is created when the tenderer is quoting for the first corresponding to a tender will be the ‘Genesis block’. All the next file systems that are created will be attached to the previous block using linked list concept. 
To store the encrypted quoted price, timestamp of when quote is made , hashcode of the file[hashcode is the digest of the contents present in the file].

![fsn](https://user-images.githubusercontent.com/25890584/85338560-83ff1e80-b4b0-11ea-94a4-859bdf39de9d.png)

4. API for SMS
	To send the login credentials to the users from Admin, we have used a sms-api. Additionally, for security purposes i.e., for authentication of user, a message stating that ‘the user has opened his/her account’ will be sent each time the user logins. [23]


![image](https://user-images.githubusercontent.com/25890584/85338697-c7598d00-b4b0-11ea-9d37-b5fddd77f5eb.png)

RESULTS:
How tender is accepted.

![image](https://user-images.githubusercontent.com/25890584/85338887-1ef7f880-b4b1-11ea-84ba-fe6a6b25c601.png)


![image](https://user-images.githubusercontent.com/25890584/85339046-59619580-b4b1-11ea-8b9a-bf262d7895dc.png)


UseCase Diagram:

![image](https://user-images.githubusercontent.com/25890584/85337586-c45d9d00-b4ae-11ea-8891-8fc9b1947a8c.png)



Supervisor of the project:
Dr. DEEPAK SUKHEJA
Associate Professor
Department of CSE
VNRVJIET, HYD.

