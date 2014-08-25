int history_count = 0;
void getTextLine()
{
        destroyCommand();
        while ((userInput != '\n') && (bufferChars < BUFFER_MAX_LENGTH)) {
                buffer[bufferChars++] = userInput;
                userInput = getchar();

		/*if(strcmp("!1", userInput) == 0){

		}*/
        }
	//printf("history_count: %d\n", history_count);
	if(history_count < 10){
		int len = sizeof(buffer)/sizeof(char);
		char bufP[2];
		bufP[0] = buffer[0];
		bufP[1] = '\0';
		//printf("bufP: %s\n", bufP);
		//history[history_count] = buffer[0];
		if(strcmp(bufP, "!") != 0){
			int column;
			for(column = 0; column < len; column++){
				history[history_count][column] = buffer[column];
			}
			history_count++;
		}
	}

        buffer[bufferChars] = 0x00;
        populateCommand();
}
void populateCommand()
{
        char* bufferPointer;
        bufferPointer = strtok(buffer, " ");
	int number = 0;
	//char historyPointer[60];
	char *historyString;
	//char *oldCommand;

	if(strcmp(bufferPointer, "!1") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[0][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!2") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[1][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!3") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[2][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!4") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[3][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!5") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[4][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!6") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[5][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!7") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[6][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!8") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[7][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!9") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[8][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else if(strcmp(bufferPointer, "!10") == 0){
		int i;
		for(i = 0; i < 60; i++){
			historyPointer[i] = history[9][i];
		}
		historyString = strtok(historyPointer, " ");
		while(historyString != NULL){
			commandArgv[commandArgc] = historyString;
			printf("%s ", commandArgv[commandArgc]);
			historyString = strtok(NULL, " ");
			commandArgc++;
		}
		printf("\n");
	}
	else{

        	while (bufferPointer != NULL) {

		/*if(strcmp(bufferPointer, "!1") == 0){
			//printf("Testing if statement.\n");
			int i;
			for(i = 0; i < 60; i++){
				historyPointer[i] = history[0][i];
			}
			historyString = strtok(historyPointer, " ");
			//oldCommand = strtok(historyString, " ");
			while(historyString != NULL){
				//printf("oldCommand: %s\n", oldCommand);
				bufferPointer = historyString;
				//commandArgv[commandArgc] = historyString;
				commandArgv[commandArgc] = bufferPointer;
				printf("historyString in commandArgv in while loop: %s\n", commandArgv[commandArgc]);
				//printf("oldCommand in commandArgv: %s\n", commandArgv[commandArgc]);
				//oldCommand = strtok(NULL, " ");
				historyString = strtok(NULL, " ");
				bufferPointer = strtok(NULL, " ");
				commandArgc++;
			}*/

		//}else{
			//printf("bufferPointer: %s\n", bufferPointer);
			commandArgv[commandArgc] = bufferPointer;
			//printf("bufferPointer in commandArgv in while loop: %s\n", commandArgv[commandArgc]);
                	bufferPointer = strtok(NULL, " ");
                	commandArgc++;
		//}
        	}
	/*int j;
	for(j = 0; j < commandArgc; j++){
		printf("commandArgv out of while loop: %s ", commandArgv[j]);
	}
	printf("\n");*/
	}
}

void destroyCommand()
{
        while (commandArgc != 0) {
                commandArgv[commandArgc] = NULL;
                commandArgc--;
        }
	int i;
	int length = sizeof(buffer)/sizeof(char);
	for(i = 0; i < length; i++){
		buffer[i] = '\0';
	}
        bufferChars = 0;
}


t_job* insertJob(pid_t pid, pid_t pgid, char* name, char* descriptor,
                 int status)
{
        usleep(10000);
        t_job *newJob = malloc(sizeof(t_job));

        newJob->name = (char*) malloc(sizeof(name));
        newJob->name = strcpy(newJob->name, name);
        newJob->pid = pid;
        newJob->pgid = pgid;
        newJob->status = status;
        newJob->descriptor = (char*) malloc(sizeof(descriptor));
        newJob->descriptor = strcpy(newJob->descriptor, descriptor);
        newJob->next = NULL;

        if (jobsList == NULL) {
                numActiveJobs++;
                newJob->id = numActiveJobs;
                return newJob;
        } else {
                t_job *auxNode = jobsList;
                while (auxNode->next != NULL) {
                        auxNode = auxNode->next;
                }
                newJob->id = auxNode->id + 1;
                auxNode->next = newJob;
                numActiveJobs++;
                return jobsList;
        }
}


int changeJobStatus(int pid, int status)
{
        usleep(10000);
        t_job *job = jobsList;
        if (job == NULL) {
                return 0;
        } else {
                int counter = 0;
                while (job != NULL) {
                        if (job->pid == pid) {
                                job->status = status;
                                return TRUE;
                        }
                        counter++;
                        job = job->next;
                }
                return FALSE;
        }
}

t_job* delJob(t_job* job)
{
        usleep(10000);
        if (jobsList == NULL)
                return NULL;
        t_job* currentJob;
        t_job* beforeCurrentJob;

        currentJob = jobsList->next;
        beforeCurrentJob = jobsList;

        if (beforeCurrentJob->pid == job->pid) {

                beforeCurrentJob = beforeCurrentJob->next;
                numActiveJobs--;
                return currentJob;
        }

        while (currentJob != NULL) {
                if (currentJob->pid == job->pid) {
                        numActiveJobs--;
                        beforeCurrentJob->next = currentJob->next;
                }
                beforeCurrentJob = currentJob;
                currentJob = currentJob->next;
        }
        return jobsList;
}

t_job* getJob(int searchValue, int searchParameter)
{
        usleep(10000);
        t_job* job = jobsList;
        switch (searchParameter) {
        case BY_PROCESS_ID:
                while (job != NULL) {
                        if (job->pid == searchValue)
                                return job;
                        else
                                job = job->next;
                }
                break;
        case BY_JOB_ID:
                while (job != NULL) {
                        if (job->id == searchValue)
                                return job;
                        else
                                job = job->next;
                }
                break;
        case BY_JOB_STATUS:
                while (job != NULL) {
                        if (job->status == searchValue)
                                return job;
                        else
                                job = job->next;
                }
                break;
        default:
                return NULL;
                break;
        }
        return NULL;
}

void printJobs()
{
        printf("\nActive jobs:\n");
        printf(
                "---------------------------------------------------------------------------\n");
        printf("| %7s  | %30s | %5s | %10s | %6s |\n", "job no.", "name", "pid",
               "descriptor", "status");
        printf(
                "---------------------------------------------------------------------------\n");
        t_job* job = jobsList;
        if (job == NULL) {
                printf("| %s %62s |\n", "No Jobs.", "");
        } else {
                while (job != NULL) {
                        printf("|  %7d | %30s | %5d | %10s | %6c |\n", job->id, job->name,
                               job->pid, job->descriptor, job->status);
                        job = job->next;
                }
        }
        printf(
                "---------------------------------------------------------------------------\n");
}

void welcomeScreen()
{
        printf("\nWelcome to the shell program!");
        printf("\n\n");
}

void shellPrompt()
{
        printf("myShell> ");
}


