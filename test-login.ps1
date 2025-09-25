$headers = @{
    "Content-Type" = "application/json"
}

$body = @{
    username = "admin"
    password = "admin123"
} | ConvertTo-Json

try {
    Write-Host "Testing login with admin credentials..."
    $response = Invoke-RestMethod -Uri "http://localhost:8081/api/auth/login" -Method POST -Headers $headers -Body $body
    Write-Host "Success: $($response | ConvertTo-Json)"
} catch {
    Write-Host "Error: $($_.Exception.Message)"
    Write-Host "Status Code: $($_.Exception.Response.StatusCode)"
    if ($_.Exception.Response) {
        $reader = New-Object System.IO.StreamReader($_.Exception.Response.GetResponseStream())
        $responseBody = $reader.ReadToEnd()
        Write-Host "Response Body: $responseBody"
    }
}