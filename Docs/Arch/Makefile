all: docs doxygen

docs: 
	javadoc -private -d javadoc *.java 

doxygen: 
	doxygen Doxyfile 

publish: doxygen
	rm -rf ~/www/blugoo/newarch
	mv doxy/html/ ~/www/blugoo/newarch
	chmod -R 755 ~/www/blugoo

print: doxygen
	make -C ./doxy/latex
	pdf2ps ./doxy/latex/refman.pdf
	lp -o sides=two-sided-long-edge refman.ps

clean:
	@rm -rvf doxy javadoc
	@rm -vf *~ refman.ps

