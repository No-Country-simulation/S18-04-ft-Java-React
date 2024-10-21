'use client';

import { useEffect, useState } from 'react';

const payload = {
  method: 'GET',
  headers: { 'Content-Type': 'application/json' },
};

export const CheckLogin = () => {
  const [val, setVal] = useState(false);
  useEffect(() => {
    console.log('CheckLogin');

    if (!val) {
      try {
        fetch('https://nocountry.up.railway.app/api/auth/check-login', payload).then(res => {
          console.log({ res });
        });
      } catch (e) {
        console.log({ e });
      }
      setVal(true);
    }
  }, []);
  return <div className="sr-only">Check login</div>;
};
