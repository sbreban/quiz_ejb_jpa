#!/usr/bin/env bash

$1/bin/asadmin undeploy quiz
$1/bin/asadmin deploy ../build/libs/quiz.war