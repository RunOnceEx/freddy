// Freddy the Serial(isation) Killer
// 
// Released as open source by NCC Group Plc - https://www.nccgroup.trust/
//
// Project link: https://github.com/nccgroup/freddy/
//
// Released under agpl-3.0 see LICENSE for more information

package nb.freddy.modules;

import burp.IHttpRequestResponse;
import burp.IHttpService;

import java.util.List;

/***********************************************************
 * Burp Collaborator payload record used to track which
 * IDs were generated by which Freddy modules in order to
 * report appropriate issues when Collaborator
 * interactions occur.
 *
 * Written by Nicky Bloor (@NickstaDB).
 **********************************************************/
class CollaboratorRecord {
    private final String _collabId;
    private final String _collabHostname;
    private final IHttpRequestResponse _baseReqRes;
    private final IHttpRequestResponse _newReqRes;
    private final IHttpService _httpService;
    private final byte[] _requestBody;
    private final List<int[]> _reqMarkers;
    private final boolean _activeScanRecord;

    /*******************
     * Initialise a Collaborator record.
     *
     * @param collaboratorId The ID generated by Burp Collaborator.
     * @param collabHostname The full ID and hostname used in the Collaborator payload.
     * @param baseReqRes The targeted base HTTP request and response.
     * @param newReqRes The HTTP request/response containing the Collaborator payload.
     * @param reqMarkers Markers indicating the start and end of the Collaborator payload in the request.
     * @param activeScan True if this Collaborator record was generated from an active scan (false for Intruder).
     ******************/
    public CollaboratorRecord(String collaboratorId, String collabHostname, IHttpRequestResponse baseReqRes, IHttpRequestResponse newReqRes, List<int[]> reqMarkers, boolean activeScan) {
        _collabId = collaboratorId;
        _collabHostname = collabHostname;
        _baseReqRes = baseReqRes;
        _newReqRes = newReqRes;
        _httpService = baseReqRes.getHttpService();
        _requestBody = newReqRes.getRequest();
        _reqMarkers = reqMarkers;
        _activeScanRecord = activeScan;
    }

    /*******************
     * Getters
     ******************/
    public String getCollaboratorId() {
        return _collabId;
    }

    public String getHostname() {
        return _collabHostname;
    }

    public byte[] getRequestBody() {
        return _requestBody;
    }

    public IHttpService getHttpService() {
        return _httpService;
    }

    public IHttpRequestResponse getBaseRequestResponse() {
        return _baseReqRes;
    }

    public IHttpRequestResponse getNewRequestResponse() {
        return _newReqRes;
    }

    public List<int[]> getRequestMarkers() {
        return _reqMarkers;
    }
}
