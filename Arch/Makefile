all: javadocs doxygen

javadocs: 
	javadoc -quiet -private -d javadoc blugoo/WEB-INF/src/java/blugoo/*.java 

doxygen: 
	rm -rf doxy
	doxygen Doxyfile 

publish: javadocs doxygen latex
	rm -rf /var/www/html/doxygen
	rm -rf /var/www/html/javadocs
	mv doxy/html/ /var/www/html/doxygen
	mv javadoc/ /var/www/html/javadocs
	mv doxy/latex/refman.pdf /var/www/html/blugooarch.pdf
	chmod -R 755 /var/www/html/*

latex: doxygen
	make -C ./doxy/latex
	cp -f doxy/latex/refman.pdf arch.pdf

print: latex
	pdf2ps ./doxy/latex/refman.pdf
	lp -o sides=two-sided-long-edge refman.ps

clean:
	@rm -rvf doxy javadoc
	@rm -vf *~ refman.ps

