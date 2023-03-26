package org.example;
import java.util.HashMap;
import java.util.Map;
public class TablaHash {


    public class ShipData {
        private Map<String, Integer> battleships;
        private Map<String, Integer> frigates;
        private Map<String, Integer> canoes;

        public ShipData() {
            battleships = new HashMap<String, Integer>();
            frigates = new HashMap<String, Integer>();
            canoes = new HashMap<String, Integer>();
        }

        public void addBattleship(String name, int count) {
            battleships.put(name, count);
        }

        public void addFrigate(String name, int count) {
            frigates.put(name, count);
        }

        public void addCanoe(String name, int count) {
            canoes.put(name, count);
        }

        public int getBattleshipCount(String name) {
            return battleships.getOrDefault(name, 0);
        }

        public int getFrigateCount(String name) {
            return frigates.getOrDefault(name, 0);
        }

        public int getCanoeCount(String name) {
            return canoes.getOrDefault(name, 0);
        }
    }



}
