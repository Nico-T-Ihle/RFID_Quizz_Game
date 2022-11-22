#!/bin/sh

echo "==============Now running write.py...======================"
python3 write.python3
echo "==============Now running sendInputTo.py...================"
python3 sendInputTo.py
echo "==============Finished!============"