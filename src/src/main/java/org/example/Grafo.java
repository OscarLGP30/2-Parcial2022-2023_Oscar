package org.example;
import java.util .*;
public class Grafo {



    public class GrafoNoDirigido {
        private Map<String, List<Arista>> grafo;

        public GrafoNoDirigido() {
            this.grafo = new HashMap<>();
        }

        public void agregarPuerto(String puerto) {
            if (!grafo.containsKey(puerto)) {
                grafo.put(puerto, new ArrayList<>());
            }
        }

        public void agregarArista(String origen, String destino, double distancia) {
            if (!grafo.containsKey(origen) || !grafo.containsKey(destino)) {
                throw new IllegalArgumentException("Puerto no existente");
            }
            Arista arista = new Arista(destino, distancia);
            grafo.get(origen).add(arista);
            grafo.get(destino).add(new Arista(origen, distancia)); // Agregar arista en ambas direcciones
        }

        public void eliminarPuerto(String puerto) {
            if (!grafo.containsKey(puerto)) {
                throw new IllegalArgumentException("Puerto no existente");
            }
            grafo.remove(puerto);
            for (Map.Entry<String, List<Arista>> entry : grafo.entrySet()) {
                List<Arista> aristas = entry.getValue();
                aristas.removeIf(a -> a.getDestino().equals(puerto));
            }
        }

        public void barridoEnProfundidad(String puertoInicial) {
            if (!grafo.containsKey(puertoInicial)) {
                throw new IllegalArgumentException("Puerto no existente");
            }
            Set<String> visitados = new HashSet<>();
            barridoEnProfundidadAux(puertoInicial, visitados);
        }

        private void barridoEnProfundidadAux(String puerto, Set<String> visitados) {
            System.out.println(puerto);
            visitados.add(puerto);
            List<Arista> aristas = grafo.get(puerto);
            for (Arista arista : aristas) {
                String destino = arista.getDestino().toString();
                if (!visitados.contains(destino)) {
                    barridoEnProfundidadAux(destino, visitados);
                }
            }
        }

        public List<String> caminoMasCorto(String puertoInicial, String puertoFinal) {
            if (!grafo.containsKey(puertoInicial) || !grafo.containsKey(puertoFinal)) {
                throw new IllegalArgumentException("Puerto no existente");
            }
            Map<String, Double> distancias = new HashMap<>();
            Map<String, String> padres = new HashMap<>();
            PriorityQueue<String> cola = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));
            for (String puerto : grafo.keySet()) {
                distancias.put(puerto, Double.POSITIVE_INFINITY);
                padres.put(puerto, null);
            }
            distancias.put(puertoInicial, 0.0);
            cola.offer(puertoInicial);
            while (!cola.isEmpty()) {
                String puerto = cola.poll();
                if (puerto.equals(puertoFinal)) {
                    break;
                }
                List<Arista> aristas = grafo.get(puerto);
                for (Arista arista : aristas) {
                    String destino = arista.getDestino().toString();
                    double distancia = arista.getDistancia();
                    double nuevaDistancia = distancias.get(puerto) + distancia;
                    if (nuevaDistancia < distancias.get(destino)) {
                        distancias.put(destino, nuevaDistancia);
                        padres.put(destino, puerto);
                        cola.offer(destino);

                    }
                }
            }
            List<String> camino = new ArrayList<>();
            String puerto = puertoFinal;
            while (puerto != null) {
                camino.add(puerto);
                puerto = padres.get(puerto);
            }
            Collections.reverse(camino);
            return camino;
        }

    }
}
