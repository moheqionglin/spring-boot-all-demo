# Use commend below to generate the SSL key

If you are using Spring Boot and want to enable SSL (https) for your application on the embedded Tomcat there a few short steps you will need to take.

- Get yourself a SSL certificate
- Enable HTTPS in Spring Boot
- Redirect HTTP to HTTPS (optional)


````

    keytool -genkey -alias moheqionglin -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

    #采坑指南，很多百度来的甚至是google来的文章相互抄袭，或者没有深挖的就直接配置#server.ssl.keyStoreType: PKCS12 其实是错的。必须要用如下命令，看下到底如何配置
    keytool -list -keystore keystore.p12

    Enter keystore password:

    Keystore type: JKS
    Keystore provider: SUN

    Your keystore contains 1 entry

    moheqionglin, Jan 16, 2018, PrivateKeyEntry,
    Certificate fingerprint (SHA1): F6:26:18:EB:F2:12:04:82:86:04:10:99:E5:20:B1:BD:E6:91:25:B9
````


Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:
What is the name of your organizational unit?
  [Unknown]:
What is the name of your organization?
  [Unknown]:
What is the name of your City or Locality?
  [Unknown]:
What is the name of your State or Province?
  [Unknown]:
What is the two-letter country code for this unit?
  [Unknown]:
Is CN=Unknown, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown correct?
  [no]:  yes

