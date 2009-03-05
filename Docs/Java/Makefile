all: docs doxygen

docs: 
	javadoc -private -d javadoc *.java 

doxygen: 
	doxygen Doxyfile 

publish: doxygen
	rm -rf ~/www/blugoo/arch
	mv doxy/html/ ~/www/blugoo/arch
	chmod -R 755 ~/www/blugoo

clean:
	@rm -rvf doxy javadoc
	@rm -vf *~

