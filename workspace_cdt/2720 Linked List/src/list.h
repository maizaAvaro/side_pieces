#ifndef LIST_H
#define LIST_H

#include "node.h"

class SLL
{
	public:

		SLL();
		~SLL();

		void Insert (string searchKey, int distance);
        bool Delete (string searchKey);
        bool Search(string searchKey);
        void Print();

	private:
		Node *head;
};

#endif
