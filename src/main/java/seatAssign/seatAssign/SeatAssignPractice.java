package seatAssign.seatAssign;

import java.util.*;

public class SeatAssignPractice {
    private String preference;
    private String selectedName;
    private Integer seatNumber;

    List<Integer> front = List.of(1, 2, 3, 4, 5, 6, 7, 8);
    List<Integer> back = List.of(9, 10, 11, 12, 13, 14, 15, 16);


    List<String> allNames = Arrays.asList("윤찬영",
            "정해준",
            "권상윤",
            "문인혁",
            "허재",
            "이호연",
            "윤태우",
            "김성락",
            "전지예",
            "황승혁",
            "이채현",
            "황효진",
            "김민성",
            "박현지",
            "문성희",
            "추민영");

    public String randomName () {
        Collections.shuffle(allNames);
        selectedName = allNames.get(0);
        allNames.remove(0);

        return selectedName;
    }

    public String frontOrBack(){

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(selectedName + "님 '앞' 또는 '뒤'를 입력 해 주세요");
            preference = scanner.next();

            if(!preference.equals("앞") && (!preference.equals("뒤"))){
                System.out.println("앞 또는 뒤만 입력할 수 있습니다.");

            }else break;
        }

        return preference;
    }


    public List<Integer> fontNumberShuffle(List<Integer> front){
        Collections.shuffle(front);  //원본 리스트인 front 자체가 변경.

        return front;  // shuffle된 front가 return
    }


    public List<Integer> BackNumberShuffle (List<Integer> back){
        Collections.shuffle(back);

        return back;
    }

    public Integer getSetNumber (){

        if(preference.equals("앞") && !front.isEmpty()){
            seatNumber = front.get(0);
            front.remove(0);  //remove는 지워주면서 동시에 return도 할 수 있다. queue처럼 작동할 수 있기 때문에 굳이 get을 해 주지 않아도 됨

        }else if(preference.equals("뒤") || !back.isEmpty()){
            seatNumber = back.get(0);
            back.remove(0);

        }else if(front.isEmpty()){
            seatNumber = back.get(0);
            back.remove(0);
        }else
            seatNumber = front.get(0);
            front.remove(0);

            return seatNumber;

    }

    HashMap<String, Integer> nameAndSeat = new HashMap<>();
    public HashMap<String, Integer> getNameAndSeat (){

        //반복문으로 만들어둔 selectedName과 seatNumber를 map에 넣기
        while (!allNames.isEmpty()) { //allNames가 empty면 반복문 stop
            randomName();
            getSetNumber();
            nameAndSeat.put(selectedName, seatNumber);

        }return nameAndSeat;
    }

    public void println (){
        System.out.println(nameAndSeat);
    }

}
