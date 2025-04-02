package han.triptop.groepB3.authorisation;

import org.json.JSONObject;

public record JsonResponse(
        String json
) {
    public JSONObject toJsonObject()
        throws org.json.JSONException
    {

    }
}
