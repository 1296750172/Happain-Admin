FROM scottyengineering/java11

ADD *.jar wx.jar

EXPOSE 80

ENTRYPOINT ["java","-jar","wx.jar"]






