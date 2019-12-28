    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty) break;
            if (tx > ty) {
                if (ty > sy) {
                    while (tx > ty) {
                        tx = tx % ty;
                    }
                } else {
                    return ((tx - sx)% ty == 0);  
                } 
            } else {
                if (tx > sx) {
                    while (ty > tx) {
                        ty %= tx;
                    }
                } else {
                    return ((ty - sy)% tx == 0);
                }
            }
        }
        
        return (sx == tx && ty == sy);
    }