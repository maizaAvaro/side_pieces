################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../src/Test.cpp \
../src/complexshape.cpp \
../src/line.cpp \
../src/rectangle.cpp \
../src/round.cpp \
../src/triangle.cpp 

CXX_SRCS += \
../src/point.cxx \
../src/shape.cxx 

OBJS += \
./src/Test.o \
./src/complexshape.o \
./src/line.o \
./src/point.o \
./src/rectangle.o \
./src/round.o \
./src/shape.o \
./src/triangle.o 

CPP_DEPS += \
./src/Test.d \
./src/complexshape.d \
./src/line.d \
./src/rectangle.d \
./src/round.d \
./src/triangle.d 

CXX_DEPS += \
./src/point.d \
./src/shape.d 


# Each subdirectory must supply rules for building sources it contributes
src/%.o: ../src/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

src/%.o: ../src/%.cxx
	@echo 'Building file: $<'
	@echo 'Invoking: Cygwin C++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


