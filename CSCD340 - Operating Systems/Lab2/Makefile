CC = gcc

FLAGS = -c -m32

OBJS = ./utils/fileUtils.o ./stock/stock.o ./utils/basicUtils.o ./genericArray/genericArray.o

MAIN = cscd340Lab2.c

EXE = ./lab2

all:	${EXE}

${EXE}:	${OBJS} ${MAIN}
	${CC} ${OBJS} ${MAIN} -o ${EXE}


stock.o:	./stock/stock.c ./stock/stock.h
	${CC} ${FLAGS} stock.c


fileUitls.o:	./utils/fileUtils.c ./utils/fileUtils.h
	${CC} ${FLAGS} fileUtil.c


basicUtils.o:	./utils/basicUtils.c ./utils/basicUtils.h
	${CC} ${FLAGS} basicUtil.c


genericArray.o:	./genericArray/genericArray.c ./genericArray/genericArray.f
	${CC} ${FLAGS} ./genericArray/genericArray.c

clean:
	rm -rf ./stock/*.o
	rm -rf ./utils/*.o
	rm -rf ./genericArray/*.o
	rm -rf ${EXE}
