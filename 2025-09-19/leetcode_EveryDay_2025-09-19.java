import java.util.HashMap;

class Spreadsheet {
    private Integer rows;
    private HashMap<String,Integer> cells;
    public Spreadsheet(int rows) {
        this.rows = rows;
        this.cells = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        String[] part = formula.substring(1).split("\\+");
        return get(part[0]) + get(part[1]);
    }
    private int get(String s)
    {
        try{
            return Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            return cells.getOrDefault(s,0);
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */