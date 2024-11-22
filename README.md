# Read me

The following original idea is from

https://snowcloudbyte.medium.com/spring-boot-3-logback-and-logstash-integrated-with-elasticsearch-and-kibana-a184c46e5b8e

This project demonstrates that logs collected by Logstash are sent to Elesticsearch. Then we can use Kibana to search
for logs visually

There is another example here that makes logstash read log files
https://medium.com/@shala.p02/centralized-logging-using-elk-as-a-docker-container-for-microservices-in-just-4-steps-4f4cdf278712

# What is Logstash

A log pipeline tool that accepts inputs from various sources, executes different transformations, and exports the data
to various targets such as Elasticsearch.

# What is Kibana

Kibana is an open-source data visualization and exploration tool designed for use with Elasticsearch.
Kibana provides a user-friendly interface for exploring, analyzing, and visualizing data(logs) stored in Elasticsearch
indices.

# Elasticsearch

http://localhost:5601

# LogstashEncoder

This third party library was intended to use with logstash, but is now used quite commonly as standard JSON formatter.

The original idea is from  
https://medium.com/engineered-publicis-sapient/consistent-logging-with-logstash-for-microservices-sharing-a-kubernetes-cluster-7c1aee7ec42f

**LogstashEncoder**
We can use like this

```
<appender name="STDOUT" class="ConsoleAppender">
  <encoder class="net.logstash.logback.encoder.LogstashEncoder" />
</appender>
```

**logback JsonEncoder**
If you prefer not to use a third party library, you can also use JsonEncode. We can use like this

```
<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
  <encoder class="ch.qos.logback.classic.encoder.JsonEncoder"/>
</appender>
```

**logback JsonLayout**
If you prefer not to use a third party library, you can also use JsonEncode. We can use like this

```
<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
  <layout class="ch.qos.logback.contrib.json.classic.JsonLayout">
    <jsonFormatter class="ch.qos.logback.contrib.jackson.JacksonJsonFormatter">
      <prettyPrint>false</prettyPrint>
    </jsonFormatter>
    <timestampFormat>yyyy-MM-dd HH:mm:ss.SSS</timestampFormat>
    <appendLineSeparator>true</appendLineSeparator>
  </layout>
</appender>
```

requires these dependencies

```
<dependency>
  <groupId>ch.qos.logback.contrib</groupId>
  <artifactId>logback-json-classic</artifactId>
  <version>0.1.5</version>
</dependency>
<dependency>
  <groupId>ch.qos.logback.contrib</groupId>
  <artifactId>logback-jackson</artifactId>
  <version>0.1.5</version>
</dependency>
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.9.0</version>
</dependency>
```

# LoggingEventCompositeJsonEncoder

We can customize the format using LoggingEventCompositeJsonEncoder as the encoder instead of LogstashEncoder, as it
provides greater flexibility in the JSON format.

LoggingEventCompositeJsonEncoder is composed of one or more JSON providers that contribute to the JSON output. No
providers are configured by default in the composite encoders — we must add the ones we want.

