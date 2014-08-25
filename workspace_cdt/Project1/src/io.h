#ifndef IO_H
#define IO_H

#include <vector>

std::vector<std::vector<double> > readMatrix(const char *);
void writeMatrix(std::vector<std::vector<double> > const &, const char *);

#endif
