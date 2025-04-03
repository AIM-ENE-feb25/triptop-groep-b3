package han.triptop.groepB3.model;

import org.json.JSONObject;

public record JsonResponse(
        String json
) {
    public JSONObject toJsonObject()
        throws org.json.JSONException
    {
        return new JSONObject(this.json);
    }
}
