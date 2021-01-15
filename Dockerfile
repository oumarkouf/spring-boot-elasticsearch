FROM devpico-pfc.dev.echonet:8083/elasticsearch:7.10.1

# Copy configuration
COPY config/elasticsearch.yml /usr/share/elasticsearch/config/elasticsearch.yml

# Set environment variables defaults
ENV CLUSTER_NAME LiferayElasticsearchCluster
ENV NODE_MASTER true
ENV NODE_DATA true
ENV NODE_INGEST true
ENV HTTP_ENABLE true
ENV NETWORK_HOST _site_
ENV HTTP_CORS_ENABLE true
ENV HTTP_CORS_ALLOW_ORIGIN *
ENV NUMBER_OF_MASTERS 1
ENV MAX_LOCAL_STORAGE_NODES 1
ENV SHARD_ALLOCATION_AWARENESS ""
ENV SHARD_ALLOCATION_AWARENESS_ATTR ""

RUN	chmod 777 /usr/share/elasticsearch/config/* && \
	chown -hR 1000:1000 /usr/share/elasticsearch/* 

# Export HTTP & Transport
EXPOSE 9200 9300

# Volume for Elasticsearch data
VOLUME ["/usr/share/elasticsearch/data"]

USER 1000

#CMD ["/run.sh"]
