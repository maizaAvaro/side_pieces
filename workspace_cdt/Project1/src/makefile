matrix:	main.cpp io.h io.cpp op.h op.cpp
	g++ -o matrix main.cpp io.cpp op.cpp

testio:	io.h io.cpp
	g++ -o testio testio.cpp io.cpp

testop:	op.h op.cpp io.h io.cpp
	g++ -o testop testop.cpp op.cpp io.cpp

clean:
	rm -f matrix testio testop *write result

