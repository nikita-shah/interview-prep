package dsa.greedy;

import java.util.ArrayList;

public class FinishMaximumJobs {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        int count = 0;
        int currTime = 0;
        ArrayList<Job> jobs= new ArrayList<>();
        for(int i=0;i<A.size();i++)
        {
            Job job = new Job(A.get(i),B.get(i));
            jobs.add(job);
        }
        jobs.sort((job1,job2)->job1.endTime-job2.endTime);
        for(int i=0;i<A.size();i++)
        {
           if(jobs.get(i).startTime >= currTime)
           {
               count++;
               currTime = jobs.get(i).endTime;
           }
        }
        return count;
    }

}

class Job
{
    int startTime;
    int endTime;
    Job(int startTime, int endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}