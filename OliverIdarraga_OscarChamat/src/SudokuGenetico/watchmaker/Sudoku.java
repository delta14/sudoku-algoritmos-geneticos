package SudokuGenetico.watchmaker;

public final class Sudoku {

    public final Gen[] cells;
    public final Coordenadas c;

    public Sudoku(Gen[] cells, Coordenadas c) {
        this.c = c;
        this.cells = cells;
    }

    public int getValor(int fila, int col) {
        return cells[c.campo(fila, col)].getValue();
    }

    public boolean isInicial(int fila, int col) {
        return cells[c.campo(fila, col)].isInicial();
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Gen cell : cells) {
            buffer.append(' ');
            buffer.append(cell.getValue());
            buffer.append('\n');
        }
        return buffer.toString();
    }

    public static final class Gen {

        private int valor;
        public int desde, hasta;
        private boolean inicial;

        public Gen(int desde, int hasta, int valor, boolean inicial) {

            if (valor < desde || hasta < valor) {
                throw new IllegalArgumentException("Value must be between 1 and 9.");
            }

            this.valor = valor;
            this.inicial = inicial;
            this.desde = desde;
            this.hasta = hasta;
        }

        public int getValue() {
            return valor;
        }

        public void setValor(int valor) {
            if (valor < desde || hasta < valor) {
                throw new IllegalArgumentException("Value must be between 1 and 9.");
            }
            this.valor = valor;
        }

        public boolean isInicial() {
            return inicial;
        }

        public void setValorInicial(int valor) {
            if (valor < desde || hasta < valor) {
                throw new IllegalArgumentException("Value must be between 1 and 9.");
            }
            this.valor = valor;
            this.inicial = true;
        }

        @Override
        public String toString() {
            return "Gen{" + "valor=" + valor + ", desde=" + desde + ", hasta=" + hasta + ", inicial=" + inicial + '}';
        }
    }
}
