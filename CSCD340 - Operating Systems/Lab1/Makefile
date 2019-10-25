CC = gcc

FLAGS = -c -m32

OBJS = ./utils/fileUtils.o ./words/word.o ./utils/basicUtils.o ./genericArray/genericArray.o

MAIN = cscd340Lab1.c

EXE = ./lab1

all:	${EXE}

${EXE}:	${OBJS} ${MAIN}
	${CC} ${OBJS} ${MAIN} -o ${EXE}


word.o:	./words/word.c ./words/word.h
	${CC} ${FLAGS} word.c


fileUitls.o:	./utils/fileUtils.c ./utils/fileUtils.h
	${CC} ${FLAGS} fileUtil.c


basicUtils.o:	./utils/basicUtils.c ./utils/basicUtils.h
	${CC} ${FLAGS} basicUtil.c


genericArray.o:	./genericArray/genericArray.c ./genericArray/genericArray.f
	${CC} ${FLAGS} ./genericArray/genericArray.c

clean:
	rm -rf ./words/*.o
	rm -rf ./utils/*.o
	rm -rf ./genericArray/*.o
	rm -rf ${EXE}
