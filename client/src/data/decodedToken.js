function base64UrlDecode(base64Url) {
  const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
  return decodeURIComponent(
    atob(base64)
      .split('')
      .map(c => {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      })
      .join('')
  );
}

export const decodePayload = token => {
  const payloadBase64 = token?.split('.')?.[1];

  if (!payloadBase64) {
    return null;
  }

  try {
    const decodedPayload = JSON.parse(base64UrlDecode(payloadBase64));
    return decodedPayload;
  } catch (error) {
    return null;
  }
};
