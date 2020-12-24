FROM java:8

EXPOSE 8080

ADD target/itemlist.jar itemlist.jar

ENTRYPOINT ["java","-jar","itemlist.jar"]