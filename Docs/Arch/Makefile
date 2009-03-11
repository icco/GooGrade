all: docs doxygen

docs: 
	javadoc -private -d javadoc *.java 

doxygen: 
	doxygen Doxyfile 

publish: doxygen
	rm -rf ~/www/blugoo/arch
	mv doxy/html/ ~/www/blugoo/arch
	chmod -R 755 ~/www/blugoo

latex: doxygen
	make -C ./doxy/latex

print: latex
	pdf2ps ./doxy/latex/refman.pdf
	lp -o sides=two-sided-long-edge refman.ps

clean:
	@rm -rvf doxy javadoc
	@rm -vf *~ refman.ps

