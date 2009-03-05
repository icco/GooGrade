all: docs doxygen

docs: 
	javadoc -private -d javadoc *.java 

doxygen: 
	doxygen Doxyfile

clean:
	@rm -rvf doxy javadoc
	@rm -vf *~

