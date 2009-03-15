all: javadocs doxygen

javadocs: 
	javadoc -quiet -private -d javadoc blugoo/WEB-INF/src/java/blugoo/*.java 

doxygen: 
	rm -rf doxy
	doxygen Doxyfile 

publish: javadocs doxygen latex
	rm -rf ~/www/blugoo/arch
	rm -rf ~/www/blugoo/javadocs
	mv doxy/html/ ~/www/blugoo/arch
	mv javadoc/ ~/www/blugoo/javadocs
	mv doxy/latex/refman.pdf ~/www/blugoo/blugooarch.pdf
	chmod -R 755 ~/www/blugoo

latex: doxygen
	make -C ./doxy/latex
	cp -f doxy/latex/refman.pdf arch.pdf

print: latex
	pdf2ps ./doxy/latex/refman.pdf
	lp -o sides=two-sided-long-edge refman.ps

clean:
	@rm -rvf doxy javadoc
	@rm -vf *~ refman.ps

