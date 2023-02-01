package challenges.thedoge2021;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    class Group{
        List<Group> members;
        int[] unmatched;
        public Group(){
            members = new ArrayList<>();
            unmatched = new int[2];
        }
        boolean isSolvable(){
            return unmatched[0] == unmatched[1];
        }
    }

    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
        if(P.length == 1) return P[0] == T[0];
        else if(A.length == 0) {
            for(int i = 0; i < P.length; i++){
                if(P[i] != T[i]) return false;
            }
            return true;
        }
        int lenOfPeople = P.length, lenOfRelations = A.length;
        Group[] groupInfo = new Group[lenOfPeople];
        for(int i = 0; i < lenOfRelations; i++){
            int peopleA = A[i], peopleB = B[i];
            Group groupA = groupInfo[peopleA], groupB = groupInfo[peopleB];
            if(groupA == null && groupB == null){
                Group group = new Group();
                if(P[peopleA] != T[peopleA])
                    group.unmatched[P[peopleA] - 1]++;
                if(P[peopleB] != T[peopleB])
                    group.unmatched[P[peopleB] - 1]++;
                group.members.add(group);
                groupInfo[peopleA] = group;
                groupInfo[peopleB] = group;
            }else if(groupA == null){
                if(P[peopleA] != T[peopleA])
                    groupB.unmatched[P[peopleA] - 1]++;
                groupInfo[peopleA] = groupB;
            }else if(groupB == null){
                if(P[peopleB] != T[peopleB])
                    groupA.unmatched[P[peopleB] - 1]++;
                groupInfo[peopleB] = groupA;
            }else{
                // merge two groups
                if(groupA.members != groupB.members){
                    List<Group> membersA = groupA.members;
                    List<Group> membersB = groupB.members;
                    if(membersA.size() < membersB.size()){
                        groupB.unmatched[0] += groupA.unmatched[0];
                        groupB.unmatched[1] += groupA.unmatched[1];
                        membersB.addAll(membersA);
                        for(Group group : membersA){
                            group.members = groupB.members;
                            group.unmatched = groupB.unmatched;
                        }
                    }else{
                        groupA.unmatched[0] += groupB.unmatched[0];
                        groupA.unmatched[1] += groupB.unmatched[1];
                        membersA.addAll(membersB);
                        for(Group group : membersB){
                            group.members = groupA.members;
                            group.unmatched = groupA.unmatched;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < lenOfPeople; i++){
            if(P[i] != T[i]){
                if(groupInfo[i] == null || !groupInfo[i].isSolvable())
                    return false;
            }
        }
        return true;
    }
}
