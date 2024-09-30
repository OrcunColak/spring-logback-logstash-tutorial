# Kibana

The following original idea is from

https://snowcloudbyte.medium.com/spring-boot-3-logback-and-logstash-integrated-with-elasticsearch-and-kibana-a184c46e5b8e

This adds support for Kibana

# Elasticsearch

http://localhost:5601

# LogstashEncoder

The original idea is from  
https://medium.com/engineered-publicis-sapient/consistent-logging-with-logstash-for-microservices-sharing-a-kubernetes-cluster-7c1aee7ec42f

We can use like this

````
<encoder class="net.logstash.logback.encoder.LogstashEncoder"/>
````

# LoggingEventCompositeJsonEncoder

We can customize the format using LoggingEventCompositeJsonEncoder as the encoder instead of LogstashEncoder, as it
provides greater flexibility in the JSON format.

LoggingEventCompositeJsonEncoder is composed of one or more JSON providers that contribute to the JSON output. No
providers are configured by default in the composite encoders — we must add the ones we want.

