#include <stdio.h>
#include "headers.h"
#include "implements.h"
#define MAXLINE 4096

void handleUserCommand()
{
 //       if( chk_pipe()==1)
   //     {

        if (checkBuiltInCommands() == 0) {
		//printf("%d",commandArgc);

		//add_command_to_history(commandArgv);
		//printf("command Argv: %s\n", commandArgv);
                launchJob(commandArgv, "STANDARD", 0, FOREGROUND);
                              //puts(commandArgv[1]);
        }
}

 //int check_pipe()
 //{
 void pipelining(int flag)
 {
    char    line[MAXLINE];
    FILE    *fpin, *fpout;
    char arg1[50],arg2[50];
    int i;
   if(flag==2)
   {
	    strcat(arg1,commandArgv[0]);
	    strcpy(arg2,commandArgv[2]);
   }
    else
   {
	   for(i=0;i<flag-1;i++)
	   {
		   strcat(arg1,commandArgv[i]);
		   strcat(arg1," ");
	   }
	   strcpy(arg2,commandArgv[commandArgc-1]);
   }
   fprintf(stdout, "command entered: ");
   puts(commandArgv[0]);
   fprintf(stdout, "first argument of pipe: ");
   puts(arg1);
   fprintf(stdout, "second argument of pipe: ");
   puts(arg2);
   //puts(commandArgv[0]);
   //puts(arg1);
   //puts(arg2);

    if ((fpin = popen(arg1, "r")) == NULL)
        printf("can't open %s", arg1);

    if ((fpout = popen(arg2, "w")) == NULL)
        printf("popen error");


    while (fgets(line, MAXLINE, fpin) != NULL) {
        if (fputs(line, fpout) == EOF)
            printf("fputs error to pipe");
    }

    //pclose(fpin);
    //pclose(fpout);

    if (ferror(fpin))
        printf("fgets error");
    if (pclose(fpout) == -1)
        printf("file closed\n");


    //return 1;
}


int checkBuiltInCommands()
{
        if (strcmp("exit", commandArgv[0]) == 0) {
                puts("\nExiting. Thanks for using myShell!\n");
		exit(EXIT_SUCCESS);
        }
        if (strcmp("cd", commandArgv[0]) == 0) {
		//add_command_to_history(commandArgv[0]);
                changeDirectory();
                return 1;
        }
       /* if (strcmp("in", commandArgv[0]) == 0) {
                launchJob(commandArgv + 2, *(commandArgv + 1), STDIN, FOREGROUND);
                return 1;
        }
        if (strcmp("out", commandArgv[0]) == 0) {
                launchJob(commandArgv + 2, *(commandArgv + 1), STDOUT, FOREGROUND);
                return 1;
        }*/
        if (strcmp("bg", commandArgv[0]) == 0) {
                //add_command_to_history(commandArgv[0]);

		if (commandArgv[1] == NULL)
                        return 0;
                /*if (strcmp("in", commandArgv[1]) == 0)
                        launchJob(commandArgv + 3, *(commandArgv + 2), STDIN, BACKGROUND);
                else if (strcmp("out", commandArgv[1]) == 0)
                        launchJob(commandArgv + 3, *(commandArgv + 2), STDOUT, BACKGROUND);
                else
                        launchJob(commandArgv + 1, "STANDARD", 0, BACKGROUND);*/
		int jobId = (int) atoi(commandArgv[1]);
		t_job* job = getJob(jobId, BY_JOB_ID);
		if(job == NULL)
			return 0;
		if(job->status == SUSPENDED){
			fprintf(stdout, "converting program from suspended to background wait status: ");
			puts(job->name);
			putJobBackground(job, TRUE);
			//launchJob(job->name, "STANDARD", 0, BACKGROUND);
		}
		else{
			putJobBackground(job, FALSE);
			fprintf(stdout, "program already in a wait status.");
		}
		return 1;
        }
	if (strcmp("&", commandArgv[commandArgc-1]) == 0){ // commandArgv[1] for bg after file

		//printf("%s", commandArgv[0]);
		if (strcmp("&", commandArgv[0]) == 0) // commandArgv[0] for bg after file
			return 0;
		else{
			//puts(commandArgv);
			//printf("commandArgv:  %p\n", commandArgv);
			launchJob(commandArgv, "STANDARD", 0, BACKGROUND); // ommandArgv for bg after file
		}
		return 1;
	}
	else{
		//printf("%s", commandArgv[0]);
	}
       if (strcmp("fg", commandArgv[0]) == 0) {
                //add_command_to_history(commandArgv[0]);

		if (commandArgv[1] == NULL)
                        return 0;
                int jobId = (int) atoi(commandArgv[1]);
                t_job* job = getJob(jobId, BY_JOB_ID);
                if (job == NULL)
                        return 0;
                if (job->status == SUSPENDED || job->status == WAITING_INPUT){
                        fprintf(stdout, "bringing program from background to run: ");
			puts(job->name);
			putJobForeground(job, TRUE);
		}
                else                               // status = BACKGROUND
                        putJobForeground(job, FALSE);
                return 1;
        }
        if (strcmp("jobs", commandArgv[0]) == 0) {
                //add_command_to_history(commandArgv[0]);

		printJobs();
                return 1;
        }
        if (strcmp("kill", commandArgv[0]) == 0)
        {
                //add_command_to_history(commandArgv[0]);

				if (commandArgv[1] == NULL)
                        return 0;

				char *nextCharPtr;
				char testString[10];

				strcpy(testString, commandArgv[1]);
				char *test = testString;
				if(strncmp("%", test, 1) == 0)
				{
					nextCharPtr = strtok(testString, "%");
					killJob((atoi(nextCharPtr)));
					return 1;
				}
				else{
					killJobCredit((atoi(commandArgv[1])));
					return 1;
				}
        }
	/*if(strcmp("!1", commandArgv[0]) == 0){
		char *cP;
		int number;
		cP = strtok(commandArgv[0], "!");
		number = atoi(cP)-1;
		char historyPoint[60];
		char *hisString;
		char *newCommand[10];

		int i;
		for(i = 0; i < 60; i++){
			historyPoint[i] = (char)history[number][i];
		}

		hisString = strtok(historyPoint, "");
		printf("%s\n", hisString);

		//historyPoint = history[number];
		//printf("%s\n", historyPoint);
		newCommand[0] = hisString;
		//printf("commandArgv: %s\n", commandArgv[0]);
		commandArgv[0] = newCommand[0];
		//printf("new commandArgv: %s\n", commandArgv[0]);
		//printf("%s\n", newCommand[0]);
		//launchJob(newCommand[0], "STANDARD", 0, FOREGROUND);
		//executeCommand(commandArgv[0], "STANDARD", 0, FOREGROUND);
		return 1;
	}*/
	if(strcmp("history", commandArgv[0]) == 0)
	{
		int index;
		int column;
		int count = 1;
		printf("Command History List\n");
		printf("%d:  ", count);
		for(index = 0; index < 10; index++){
			for(column = 0; column < 55; column++){
				fprintf(stdout, "%c", history[index][column]);
			}
			count++;
			//printf("%d:  ", count);
			if(count <= 10){
				printf("\n");
				printf("%d:  ", count);
			}
			if(count == 11)
				printf("\n");
			//count++;
		}
		return 1;

	}
	if(strcmp("help", commandArgv[0]) == 0)
	{

		printf("Help Menu\n");
		printf("The functionality of this shell is as follows:\n\n");
		printf("The execution of simple normal shell operations such as cat, more, echo, any user-defined program, etc. will\n");
		printf("operate exactly as they would in the bash shell.\n");
		printf("The built-in commands ls, cd, ps and pwd will operate just as they would in the bash shell as well.\n");
		printf("To start a program in the background simply append the & symbol such as, ./program &\n");
		printf("The command jobs can be used to list the processes that are currently running in the background of your shell.\n");
		printf("If a program has been suspended, such as the user entering CTRL-Z, you can background the job to wait status using\n");
		printf("the command bg <job number> e.g. bg 1\n");
		printf("If a job is in the background, either in wait-status or suspended, it can be brought to the foreground by using the\n");
		printf("command fg <job number> e.g. fg 1\n");
		printf("A job can be killed using the command kill %<job number> such as kill %1 or using the pid number, kill <pid number>\n");
		printf("You can obtain the pid number of a job from the jobs list or the ps command.\n");
		printf("Simple input/output redirection is accomplished as follows:\n");
		printf("./a.out < input  --  would run program a.out with input from file input and would write all output to stdout\n");
		printf("./a.out > output  --  would run program a.out with output of program sent to the created file output\n");
		printf("./a.out < input > output  --  would run program a.out with input from file input and would write output to the created file output.\n");
		printf("./a.out >> output  --  would run program a.out with output of program appended to the end of the previously created file output.\n");
		printf("./a.out < input >> output  --  would run program a.out with input from file input and append output to the end of the previously\n");
		printf("created file output.\n");
		printf("Simple pipe functionality has also been implemented in this shell.  An example is as follows:\n");
		printf("who | wc  --  would run command who and pipe output to the word count process\n");
		printf("To see a list of previously entered commands type history at the shell prompt, only ten commands are held in history per shell execution.\n");
		printf("To execute a previous command listed in history type !<command number> e.g. !1 at the shell prompt.");
		printf("To exit the shell program type exit at the shell prompt.\n\n");
		printf("End of Help Menu\n");
		return 1;

	}
        //int i;
        ////for( i=0;i<=commandArgc;i++)
        //{
        //char *str;
        //strcpy(str,commandArgv);
        if( commandArgc == 3 )
        {
		if(strcmp("|", commandArgv[1]) == 0  )
            	{
            		pipelining(2);
            		return 1;
           	}
		else if(strcmp("<", commandArgv[commandArgc-2]) == 0){
			int in;
			int i = 0;
			i = fork();
			if(i == 0){
				in = open(commandArgv[2], O_RDONLY);
				dup2(in, 0);
				close(in);
				executeCommand(commandArgv, "STANDARD", 0, FOREGROUND);
				//puts("test statement 1");
				dup2(0, 0);
				//printf("test statement 2");
			}else{
				waitpid(getpid(), NULL, 0);
				close(in);
			}
			return 1;
		}
		else if(strcmp(">", commandArgv[commandArgc-2]) == 0){
			int out;
			int i = 0;
			i = fork();
			if(i == 0){
				out = open(commandArgv[2], O_WRONLY | O_TRUNC | O_CREAT, S_IRUSR | S_IRGRP | S_IWGRP | S_IWUSR);
				dup2(out, 1);
				close(out);
				executeCommand(commandArgv, "STANDARD", 0, FOREGROUND);
				//printf("test statement 3");
				dup2(1, 1);
				//printf("test statement 4");
			}else{
				waitpid(getpid(), NULL, 0);
				close(out);
			}
			return 1;
		}
		else if(strcmp(">>", commandArgv[commandArgc-2]) == 0){
			int out;
			int i = 0;
			int offset;

			i = fork();
			if(i == 0){
				out = open(commandArgv[2], O_WRONLY | O_APPEND);

				offset = lseek(out, 1, SEEK_END);

				dup2(out, 1);
				close(out);

				executeCommandAppend(commandArgv, "STANDARD", 0, FOREGROUND);

				dup2(1, 1);

			}else{
				waitpid(getpid(), NULL, 0);
				close(out);
			}
			return 1;

		}

        }
	if( commandArgc > 3 )
	{
		if(strcmp(">", commandArgv[commandArgc-2]) == 0){
			int in;
			int out;
			int i = 0;
			i = fork();
			if(i == 0){
				in = open(commandArgv[2], O_RDONLY);
				out = open(commandArgv[4], O_WRONLY | O_TRUNC | O_CREAT, S_IRUSR | S_IRGRP | S_IWGRP | S_IWUSR);

				dup2(in, 0);
				dup2(out, 1);

				close(in);
				close(out);

				executeCommand(commandArgv, "STANDARD", 0, FOREGROUND);
				dup2(0, 0);
				dup2(1, 1);
			}else{
				waitpid(getpid(), NULL, 0);
				close(in);
				close(out);
			}

			return 1;

		}
		else if(strcmp("|", commandArgv[commandArgc-2]) == 0 )
		{
			//puts("works");
			//printf("%d",commandArgc);
			pipelining(commandArgc-1);
			return 1;
		}
		else if(strcmp(">>", commandArgv[commandArgc-2]) == 0){
			int in;
			int out;
			int offset;
			int i = 0;

			i = fork();
			if(i == 0){
				in = open(commandArgv[2], O_RDONLY);
				out = open(commandArgv[4], O_WRONLY |  O_APPEND);

				offset = lseek(out, 1, SEEK_END);


				dup2(in, 0);
				dup2(out, 1);

				close(in);
				close(out);

				executeCommandAppend(commandArgv, "STANDARD", 0, FOREGROUND);
				dup2(0, 0);
				dup2(1, 1);
			}else{
				waitpid(getpid(), NULL, 0);
				close(in);
				close(out);
			}

			return 1;

		}
	}
        //break;
        //}



        return 0;
}

void executeCommandAppend(char *command[], char *file, int newDescriptor,
                    int executionMode)
{
        int commandDescriptor;
        if (newDescriptor == STDIN) {
                commandDescriptor = open(file, O_RDONLY);
                dup2(commandDescriptor, STDIN_FILENO);
                close(commandDescriptor);
        }
        if (newDescriptor == STDOUT) {
                commandDescriptor = open(file, O_WRONLY | O_APPEND);
                dup2(commandDescriptor, STDOUT_FILENO);
                close(commandDescriptor);
        }
        if (execvp(*command, command) == -1){
                //puts(*command);
		perror("MyShell");
	}
}

void executeCommand(char *command[], char *file, int newDescriptor,
                    int executionMode)
{
        int commandDescriptor;
        if (newDescriptor == STDIN) {
                commandDescriptor = open(file, O_RDONLY, 0644);
                dup2(commandDescriptor, STDIN_FILENO);
                close(commandDescriptor);
        }
        if (newDescriptor == STDOUT) {
                commandDescriptor = open(file, O_CREAT | O_TRUNC | O_WRONLY, 0644);
                dup2(commandDescriptor, STDOUT_FILENO);
                close(commandDescriptor);
        }
        if (execvp(*command, command) == -1){
                //puts(*command);
		perror("MyShell");
	}
}

void launchJob(char *command[], char *file, int newDescriptor,
               int executionMode)
{
        pid_t pid;
        pid = fork();
        switch (pid) {
        case -1:
                perror("MyShell");
                exit(EXIT_FAILURE);
                break;
        case 0:
                signal(SIGINT, SIG_DFL);
                signal(SIGQUIT, SIG_DFL);
                signal(SIGTSTP, SIG_DFL);
                signal(SIGCHLD, &signalHandler_child);
                signal(SIGTTIN, SIG_DFL);
                usleep(20000);
                setpgrp();
                if (executionMode == FOREGROUND)
                        tcsetpgrp(MSH_TERMINAL, getpid());
                if (executionMode == BACKGROUND)
                        printf("[%d] %d\n", ++numActiveJobs, (int) getpid());

                executeCommand(command, file, newDescriptor, executionMode);

                exit(EXIT_SUCCESS);
                break;
        default:
                setpgid(pid, pid);

                jobsList = insertJob(pid, pid, *(command), file, (int) executionMode);

                t_job* job = getJob(pid, BY_PROCESS_ID);

                if (executionMode == FOREGROUND) {
                        putJobForeground(job, FALSE);
                }
                if (executionMode == BACKGROUND)
                        putJobBackground(job, FALSE);
                break;
        }
}

void putJobForeground(t_job* job, int continueJob)
{
        job->status = FOREGROUND;
        tcsetpgrp(MSH_TERMINAL, job->pgid);
        if (continueJob) {
                if (kill(-job->pgid, SIGCONT) < 0)
                        perror("kill (SIGCONT)");
        }

        waitJob(job);
        tcsetpgrp(MSH_TERMINAL, MSH_PGID);
}

void putJobBackground(t_job* job, int continueJob)
{
        if (job == NULL)
                return;

        if (continueJob && job->status != WAITING_INPUT)
                job->status = WAITING_INPUT;
        if (continueJob)
                if (kill(-job->pgid, SIGCONT) < 0)
                        perror("kill (SIGCONT)");

        tcsetpgrp(MSH_TERMINAL, MSH_PGID);
}

void waitJob(t_job* job)
{
        int terminationStatus;
        while (waitpid(job->pid, &terminationStatus, WNOHANG) == 0) {
                if (job->status == SUSPENDED)
                        return;
        }
        jobsList = delJob(job);
}

void killJob(int jobId)
{
        t_job *job = getJob(jobId, BY_JOB_ID);
        kill(job->pid, SIGKILL);
}

void killJobCredit(int pID)
{
	t_job *job = getJob(pID, BY_PROCESS_ID);
	kill(job->pid, SIGKILL);
}

void changeDirectory()
{
        if (commandArgv[1] == NULL) {
                chdir(getenv("HOME"));
        } else {
                if (chdir(commandArgv[1]) == -1) {
                        printf(" %s: no such directory\n", commandArgv[1]);
                }
        }
}


void init()
{
	//history[11] = {0};

        MSH_PID = getpid();
        MSH_TERMINAL = STDIN_FILENO;
        MSH_IS_INTERACTIVE = isatty(MSH_TERMINAL);

        if (MSH_IS_INTERACTIVE) {
                while (tcgetpgrp(MSH_TERMINAL) != (MSH_PGID = getpgrp()))
                        kill(MSH_PID, SIGTTIN);

                signal(SIGQUIT, SIG_IGN);
                signal(SIGTTOU, SIG_IGN);
                signal(SIGTTIN, SIG_IGN);
                signal(SIGTSTP, SIG_IGN);
                signal(SIGINT, SIG_IGN);
                signal(SIGCHLD, &signalHandler_child);

                setpgid(MSH_PID, MSH_PID);
                MSH_PGID = getpgrp();
                if (MSH_PID != MSH_PGID) {
                        printf("Error, the shell is not process group leader");
                        exit(EXIT_FAILURE);
                }
                if (tcsetpgrp(MSH_TERMINAL, MSH_PGID) == -1)
                        tcgetattr(MSH_TERMINAL, &MSH_TMODES);

                currentDirectory = (char*) calloc(1024, sizeof(char));
        } else {
                printf("Could not make MyShell interactive. Exiting...\n");
                exit(EXIT_FAILURE);
        }
}

int main(int argc, char **argv, char **envp)
{
        init();
        welcomeScreen();
        shellPrompt();
        while (TRUE) {
                userInput = getchar();
                switch (userInput) {
                case '\n':
                        shellPrompt();
                        break;
                default:
                        getTextLine();
                        handleUserCommand();
                        shellPrompt();
                        break;
                }
        }
        printf("\n");
        return 0;
}

void signalHandler_child(int p)
{
        pid_t pid;
        int terminationStatus;
        pid = waitpid(WAIT_ANY, &terminationStatus, WUNTRACED | WNOHANG);
        if (pid > 0) {
                t_job* job = getJob(pid, BY_PROCESS_ID);
                if (job == NULL)
                        return;
                if (WIFEXITED(terminationStatus)) {
                        if (job->status == BACKGROUND) {
                                printf("\n[%d]+  Done\t   %s\n", job->id, job->name);
                                jobsList = delJob(job);
				//shellPrompt();
				//printf("myShell> ");
                        }
                } else if (WIFSIGNALED(terminationStatus)) {
                        printf("\n[%d]+  KILLED\t   %s\n", job->id, job->name);
                        jobsList = delJob(job);
			//shellPrompt();
			//printf("myShell> ");
                } else if (WIFSTOPPED(terminationStatus)) {
                        if (job->status == BACKGROUND) {
                                tcsetpgrp(MSH_TERMINAL, MSH_PGID);
                                changeJobStatus(pid, WAITING_INPUT);
                                printf("\n[%d]+   suspended [wants input]\t   %s\n",
                                       numActiveJobs, job->name);
				//shellPrompt();
				//printf("myShell> ");
                        } else {
                                tcsetpgrp(MSH_TERMINAL, job->pgid);
                                changeJobStatus(pid, SUSPENDED);
                                printf("\n[%d]+   stopped\t   %s\n", numActiveJobs, job->name);
				//shellPrompt();
				//printf("myShell> ");
                        }
                        return;
                } else {
                        if (job->status == BACKGROUND) {
                                jobsList = delJob(job);
                        }
                }
                tcsetpgrp(MSH_TERMINAL, MSH_PGID);
        }
}



