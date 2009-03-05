all: docs doxygen

docs: 
	javadoc -private -d html *.java 

doxygen: 
	doxygen Doxyfile

clean:
	@rm -rvf html doxy
	@rm -vf *~

