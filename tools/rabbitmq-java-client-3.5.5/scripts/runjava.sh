#!/bin/sh
RABBIT_JARS=/Users/pgaref/Documents/workspace/rabbitmq-dev/tools/rabbitmq-java-client-3.5.5/build/lib/rabbitmq-client.jar
for d in `dirname $0`/*.jar
do
    RABBIT_JARS="$d:$RABBIT_JARS"
done
exec java -cp "$RABBIT_JARS" "$@"
