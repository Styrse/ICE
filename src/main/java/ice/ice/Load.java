package ice.ice;

import java.util.ArrayList;

public class Load {
    ArrayList<Transport> transport;

    public Load(ArrayList<Transport> transport)  {
        this.transport = transport;
    }

    public void loadPublicTransportData()  {
        ArrayList<String> data = FileIO.fileReader("data/PublicTransport");
        for (String s : data)   {
            String[] values = s.split(";");
            Transport tmpTransport = new Transport (values[0], (Double.parseDouble(values[1])), (Double.parseDouble(values[2])));
            transport.add(tmpTransport);
        }
    }

    public void loadCarData()   {

    }
}
